use std::collections::{HashSet, VecDeque};
use std::io;

fn get_nums() -> (i32, i32) {
    let mut input = String::new();

    io::stdin().read_line(&mut input).unwrap();

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

    fn add_edge(&mut self, v1: i32, v2: i32) {
        if v1 < 0 || v1 >= self.size as i32 || v2 < 0 || v2 >= self.size as i32 {
            panic!("invalid vertex");
        }

        self.vertices[v1 as usize].add_edge(v2);
        self.vertices[v2 as usize].add_edge(v1);
    }

    fn get_adjacent_vertices(&self, v: i32) -> Vec<i32> {
        if v < 0 || v >= self.size as i32 {
            panic!("invalid vertex");
        }

        self.vertices[v as usize].get_adjacent_vertices()
    }

    fn size(&self) -> usize {
        self.size
    }
}

struct DistanceInfo {
    last_vertex: i32,
    distance: i32,
}

impl DistanceInfo {
    fn new() -> Self {
        DistanceInfo {
            last_vertex: -1,
            distance: -1,
        }
    }
}

fn bfs(g: &Graph, source: i32, target: i32) {
    let mut dist = Vec::new();
    for _ in 0..g.size() {
        dist.push(DistanceInfo::new());
    }

    dist[source as usize].last_vertex = source;
    dist[source as usize].distance = 0;

    let mut visited = vec![false; g.size()];

    let mut q = VecDeque::new();
    q.push_back(source);

    while !q.is_empty() {
        let v = q.pop_front().unwrap();

        if visited[v as usize] {
            continue;
        }

        visited[v as usize] = true;

        for neighbour in &g.get_adjacent_vertices(v) {
            if !visited[*neighbour as usize] {
                if dist[*neighbour as usize].distance == -1 {
                    dist[*neighbour as usize].distance = dist[v as usize].distance + 1;
                    dist[*neighbour as usize].last_vertex = v;
                    q.push_back(*neighbour);
                }
            }
        }
    }

    println!("{}", dist[target as usize].distance);
}

fn main() {
    let (n, m) = get_nums();
    let mut g = Graph::new(n as usize);

    for _ in 0..m {
        let (from, to) = get_nums();
        g.add_edge(from - 1, to - 1);
        g.add_edge(to - 1, from - 1);
    }

    let (source, target) = get_nums();
    bfs(&g, source - 1, target - 1);
}