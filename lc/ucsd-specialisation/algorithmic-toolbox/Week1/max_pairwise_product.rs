use std::io;

fn get_num() -> i64 {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");

    input.trim().parse::<_>().unwrap()
}

fn get_nums() -> Vec<i64> {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");

    input
        .trim()
        .split_whitespace()
        .map(|d| d.parse().unwrap())
        .collect::<Vec<_>>()
}

fn main() {
    let _ = get_num();
    let mut a = get_nums();

    a.sort_by(|a, b| b.cmp(&a));

    println!("{}", a[0] * a[1]);
}