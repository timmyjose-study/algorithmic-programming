use std::io;

fn get_nums() -> (i64, i64) {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");

    let nums = input
        .trim()
        .split_whitespace()
        .map(|d| d.parse().unwrap())
        .collect::<Vec<i64>>();
    (nums[0].clone(), nums[1].clone())
}

fn main() {
    let (a, b) = get_nums();
    println!("{}", a + b);
}