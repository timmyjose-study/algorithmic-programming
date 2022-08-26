use std::cmp;
use std::io;

fn get_num() -> i32 {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    input.trim().parse::<i32>().unwrap()
}

fn get_nums() -> Vec<i32> {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    input
        .trim()
        .split_whitespace()
        .map(|d| d.parse::<i32>().unwrap())
        .collect::<Vec<_>>()
}

// O(n * W) / O(n * W)
fn knapsack(weights: &[i32], values: &[i32], capacity: i32) -> i32 {
    let mut dp = vec![vec![0; (capacity + 1) as usize]; weights.len()];

    for c in 0..=capacity {
        if weights[0] <= c {
            dp[0][c as usize] = values[0];
        }
    }

    for i in 1..weights.len() {
        for j in 1..=capacity {
            let mut choose_val = 0;
            if weights[i] <= j {
                choose_val = values[i] + dp[i - 1][(j - weights[i]) as usize];
            }
            let not_choose_val = dp[i - 1][j as usize];

            dp[i][j as usize] = cmp::max(choose_val, not_choose_val);
        }
    }

    dp[weights.len() - 1][capacity as usize]
}

fn main() {
    let _ = get_num();
    let weights = get_nums();
    let values = get_nums();
    let mut nq = get_num();

    while nq > 0 {
        let capacity = get_num();
        println!("{}", knapsack(&weights, &values, capacity));
        nq -= 1;
    }
}