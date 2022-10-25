use std::io;

fn get_num() -> i32 {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");

    input.trim().parse::<_>().unwrap()
}

fn get_pair() -> (i32, i32) {
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

fn cover_all_segments(mut ps: Vec<(i32, i32)>) {
    ps.sort_by(|p, q| p.1.cmp(&q.1));

    let mut idx = 0;
    let mut pos;
    let mut positions = Vec::new();

    loop {
        pos = ps[idx].1;
        positions.push(pos);

        while idx < ps.len() && ps[idx].0 <= pos && ps[idx].1 >= pos {
            idx += 1;
        }

        if idx == ps.len() {
            break;
        }
    }

    println!("{}", positions.len());
    for pos in positions {
        print!("{} ", pos);
    }
    println!();
}

fn main() {
    let n = get_num();
    let mut ps = Vec::with_capacity(n as usize);

    for _ in 0..n {
        ps.push(get_pair());
    }

    cover_all_segments(ps);
}