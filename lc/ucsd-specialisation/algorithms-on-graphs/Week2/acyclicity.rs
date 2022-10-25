use std::collections::{HashMap, HashSet, VecDeque};
use std::io;

fn get_nums() -> (i32, i32) {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");

    let nums = input
        .trim()
        .split_whitespace()
        .map(|d| d.parse::<i32>().unwrap())
        .collect::<Vec<_>>();

    (nums[0].clone(), nums[1].clone())
}

struct Vertex {
    vs: HashSet<i32>,
}

impl Vertex {
    fn new() -> Self {
        Vertex { vs: HashSet::new() }
    }

    fn add_edge(&mut self, v: i32) {
        self.vs.insert(v);
    }

    fn get_adjacent_vertices(&self) -> Vec<i32> {
        let mut ns = Vec::new();

        for v in &self.vs {
            ns.push(*v);
        }

        ns
    }

    fn has_edge(&self, v: i32) -> bool {
        self.vs.contains(&v)
    }
}

struct Graph {
    vertices: Vec<Vertex>,
    size: usize,
}

impl Graph {
    fn new(size: usize) -> Self {
        let mut g = Graph {
            vertices: Vec::new(),
            size: size,
        };

        for _ in 0..size {
            g.vertices.push(Vertex::new());
        }

        g
    }

    fn size(&self) -> usize {
        self.size
    }

    fn add_edge(&mut self, v1: i32, v2: i32) {
        if v1 < 0 || v1 >= self.size as i32 || v2 < 0 || v2 >= self.size as i32 {
            panic!("invalid vertex");
        }

        self.vertices[v1 as usize].add_edge(v2);
    }

    fn get_adjacent_vertices(&self, v: i32) -> Vec<i32> {
        if v < 0 || v >= self.size as i32 {
            panic!("invalid vertex");
        }

        self.vertices[v as usize].get_adjacent_vertices()
    }

    fn indegree(&self, v: i32) -> i32 {
        if v < 0 || v >= self.size as i32 {
            panic!("invalid vertex");
        }

        let mut indeg = 0;

        for i in 0..self.size {
            if self.vertices[i].has_edge(v) {
                indeg += 1;
            }
        }

        indeg
    }
}

fn main() {
    let (n, m) = get_nums();
    let mut g = Graph::new(n as usize);

    for _ in 0..m {
        let (from, to) = get_nums();
        g.add_edge(from - 1, to - 1);
    }

    let mut ordering: Vec<i32> = Vec::new();
    let mut deg: HashMap<i32, i32> = HashMap::new();
    let mut q: VecDeque<i32> = VecDeque::new();

    for i in 0..g.size() {
        let id = g.indegree(i as i32);
        deg.insert(i as i32, id);

        if id == 0 {
            q.push_back(i as i32);
        }
    }

    while !q.is_empty() {
        let v = q.pop_front().unwrap();

        ordering.push(v);

        for neighbour in g.get_adjacent_vertices(v) {
            deg.entry(neighbour).and_modify(|d| *d -= 1);

            if let Some(0) = deg.get(&neighbour) {
                q.push_back(neighbour);
            }
        }
    }

    println!("{}", if ordering.len() != g.size() { 1 } else { 0 });
}