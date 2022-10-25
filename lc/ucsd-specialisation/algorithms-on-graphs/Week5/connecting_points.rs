use std::io;

fn get_num() -> i32 {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    input.trim().parse::<_>().unwrap()
}

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

struct DSUF {
    parent: Vec<i32>,
    rank: Vec<i32>,
}

impl DSUF {
    fn new(size: usize) -> Self {
        let mut dsuf = DSUF {
            parent: vec![0; size],
            rank: vec![0; size],
        };

        for i in 0..size {
            dsuf.parent[i] = i as i32;
            dsuf.rank[i] = 0;
        }

        dsuf
    }

    fn find(&mut self, p: i32) -> i32 {
        if p != self.parent[p as usize] {
            self.parent[p as usize] = self.find(self.parent[p as usize]);
        }

        self.parent[p as usize]
    }

    fn union(&mut self, p: i32, q: i32) {
        let pid = self.find(p);
        let qid = self.find(q);

        if pid == qid {
            return;
        }

        if self.rank[pid as usize] > self.rank[qid as usize] {
            self.parent[qid as usize] = pid;
        } else {
            self.parent[pid as usize] = qid;

            if self.rank[pid as usize] == self.rank[qid as usize] {
                self.rank[qid as usize] += 1;
            }
        }
    }
}

fn main() {
    let dist = |(x1, y1), (x2, y2)| {
        let d1 = x1 - x2;
        let d2 = y1 - y2;
        ((d1 * d1 + d2 * d2) as f64).sqrt()
    };

    let n = get_num() as usize;
    let mut dsuf = DSUF::new(n);
    let mut vertices = Vec::new();

    for _ in 0..n {
        vertices.push(get_nums());
    }

    let mut edges = Vec::new();
    for i in 0..n {
        for j in i + 1..n {
            edges.push((i, j, dist(vertices[i], vertices[j])));
        }
    }

    edges.sort_by(|(_, _, d1), (_, _, d2)| d1.partial_cmp(&d2).unwrap());

    let mut min_cost = 0.0;
    for (from, to, distance) in &edges {
        if dsuf.find(*from as i32) != dsuf.find(*to as i32) {
            min_cost += distance;
            dsuf.union(*from as i32, *to as i32);
        }
    }

    println!("{:.9}", min_cost);
}