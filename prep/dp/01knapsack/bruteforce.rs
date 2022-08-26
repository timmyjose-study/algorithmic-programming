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

// O(2^n) / O(n)
fn knapsack(weights: &[i32], values: &[i32], capacity: i32) -> i32 {
    knapsack_rec(weights, values, capacity, 0)
}

fn knapsack_rec(weights: &[i32], values: &[i32], capacity: i32, curr_idx: usize) -> i32 {
    if capacity <= 0 || curr_idx >= weights.len() {
        0
    } else {
        let mut choose_val = 0;
        if weights[curr_idx] <= capacity {
            choose_val = values[curr_idx]
                + knapsack_rec(weights, values, capacity - weights[curr_idx], curr_idx + 1);
        }

        let not_choose_val = knapsack_rec(weights, values, capacity, curr_idx + 1);
        cmp::max(choose_val, not_choose_val)
    }
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