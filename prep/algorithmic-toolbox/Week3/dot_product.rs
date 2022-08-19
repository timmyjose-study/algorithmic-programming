use std::io;

fn get_num() -> i32 {
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
        .map(|d| d.parse::<_>().unwrap())
        .collect::<Vec<_>>()
}

fn max_dot_product(profits: &mut Vec<i64>, clicks: &mut Vec<i64>) -> i64 {
    profits.sort();
    clicks.sort();

    profits
        .iter()
        .zip(clicks.iter())
        .map(|(p, c)| p * c)
        .sum::<_>()
}

fn main() {
    let _ = get_num();
    let mut profits = get_nums();
    let mut clicks = get_nums();

    println!("{}", max_dot_product(&mut profits, &mut clicks));
}