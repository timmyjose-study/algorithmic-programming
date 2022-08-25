use std::collections::{HashMap, HashSet};
use std::io;

fn get_nums() -> (usize, usize) {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");

    let nums = input
        .trim()
        .split_whitespace()
        .map(|d| d.parse::<usize>().unwrap())
        .collect::<Vec<_>>();

    (nums[0].clone(), nums[1].clone())
}

trait Graph {
    fn add_edge(&mut self, from: usize, to: usize);
    fn get_adjacent_vertices(&self, v: usize) -> Vec<usize>;
    fn size(&self) -> usize;
}

struct Vertex {
    vs: HashSet<usize>,
}

impl Vertex {
    fn new() -> Self {
        Vertex { vs: HashSet::new() }
    }

    fn add_edge(&mut self, v: usize) {
        self.vs.insert(v);
    }

    fn get_adjacent_vertices(&self) -> Vec<usize> {
        let mut neighbours = Vec::new();

        for v in &self.vs {
            neighbours.push(*v);
        }

        neighbours
    }
}

struct AdjacencySet {
    size: usize,
    vertices: Vec<Vertex>,
}

impl AdjacencySet {
    fn new(size: usize) -> Self {
        let mut adj = AdjacencySet {
            size: size as usize,
            vertices: Vec::with_capacity(size as usize),
        };

        for _ in 0..size as usize {
            adj.vertices.push(Vertex::new());
        }

        adj
    }
}

impl Graph for AdjacencySet {
    fn add_edge(&mut self, from: usize, to: usize) {
        if from >= self.size || to >= self.size {
            panic!("invalid vertex for size {}", self.size);
        }

        self.vertices[from].add_edge(to);
        self.vertices[to].add_edge(from);
    }

    fn get_adjacent_vertices(&self, v: usize) -> Vec<usize> {
        if v >= self.size {
            panic!("invalid vertex");
        }

        self.vertices[v].get_adjacent_vertices()
    }

    fn size(&self) -> usize {
        self.size
    }
}

fn connected_components(g: &mut AdjacencySet) -> HashMap<usize, usize> {
    let mut cc = HashMap::new();
    let mut visited = (0..=g.size()).map(|_| false).collect::<Vec<bool>>();
    let mut cc_idx = 0;

    for idx in 0..g.size() {
        dfs(&g, idx, &mut visited, cc_idx, &mut cc);
        cc_idx += 1;
    }

    cc
}

fn dfs(
    g: &AdjacencySet,
    curr_vertex: usize,
    visited: &mut Vec<bool>,
    cc_idx: usize,
    cc: &mut HashMap<usize, usize>,
) {
    if visited[curr_vertex] {
        return;
    }

    let mut st = Vec::new();
    st.push(curr_vertex);

    while !st.is_empty() {
        let v = st.pop().unwrap();

        visited[v] = true;
        cc.insert(v, cc_idx);

        for neighbour in g.get_adjacent_vertices(v) {
            if !visited[neighbour] {
                st.push(neighbour);
            }
        }
    }
}

fn main() {
    let (n, m) = get_nums();
    let mut g = AdjacencySet::new(n);

    for _ in 0..m {
        let (from, to) = get_nums();

        g.add_edge(from - 1, to - 1);
    }

    let (mut source, mut target) = get_nums();
    source -= 1;
    target -= 1;

    let cc = connected_components(&mut g);
    println!(
        "{}",
        if cc.get(&source) == cc.get(&target) {
            1
        } else {
            0
        }
    );
}