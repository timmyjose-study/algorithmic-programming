use std::collections::{HashMap, HashSet, VecDeque};
use std::io;

fn get_nums() -> (i64, i64) {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");

    let nums = input
        .trim()
        .split_whitespace()
        .map(|d| d.parse::<i64>().unwrap())
        .collect::<Vec<_>>();

    (nums[0].clone(), nums[1].clone())
}

struct Vertex {
    vs: HashSet<i64>,
}

impl Vertex {
    fn new() -> Self {
        Vertex { vs: HashSet::new() }
    }

    fn add_edge(&mut self, v: i64) {
        self.vs.insert(v);
    }

    fn get_adjacent_neighbours(&self) -> Vec<i64> {
        let mut ns = Vec::new();

        for v in &self.vs {
            ns.push(*v);
        }
        ns
    }

    fn has_edge(&self, v: i64) -> bool {
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

    fn add_edge(&mut self, v1: i64, v2: i64) {
        if v1 < 0 || v1 >= self.size as i64 || v2 < 0 || v2 >= self.size as i64 {
            panic!("invalid vertex");
        }

        self.vertices[v1 as usize].add_edge(v2);
    }

    fn get_adjacent_neighbours(&self, v: i64) -> Vec<i64> {
        if v < 0 || v >= self.size as i64 {
            panic!("invalid vertex");
        }

        self.vertices[v as usize].get_adjacent_neighbours()
    }

    fn indegree(&self, v: i64) -> i64 {
        let mut indeg = 0;

        for i in 0..self.size() {
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

    let mut ordering: Vec<i64> = Vec::new();
    let mut deg = HashMap::new();
    let mut q = VecDeque::new();

    for i in 0..g.size() {
        let d = g.indegree(i as i64);
        deg.insert(i as i64, d);

        if d == 0 {
            q.push_back(i as i64);
        }
    }

    while !q.is_empty() {
        let v = q.pop_front().unwrap();

        ordering.push(v);

        for neighbour in g.get_adjacent_neighbours(v) {
            deg.entry(neighbour).and_modify(|d| *d -= 1);

            if let Some(0) = deg.get(&neighbour) {
                q.push_back(neighbour);
            }
        }
    }

    if ordering.len() != g.size() {
        panic!("cycle detected");
    }

    for v in &ordering {
        print!("{} ", *v + 1);
    }
    println!();
}