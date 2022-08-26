use std::cmp;
use std::collections::{BTreeMap, HashMap, HashSet, VecDeque};
use std::io;

fn get_num() -> i32 {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    input.trim().parse::<i32>().unwrap()
}

fn get_pair() -> (i32, i32) {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let nums = input
        .trim()
        .split_whitespace()
        .map(|d| d.parse::<i32>().unwrap())
        .collect::<Vec<_>>();
    (nums[0].clone(), nums[1].clone())
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

fn get_line() -> String {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    input.trim().to_owned()
}

fn main() {}