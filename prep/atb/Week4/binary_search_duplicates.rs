use std::cmp::Ordering;
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
        .map(|d| d.parse::<_>().unwrap())
        .collect::<Vec<_>>()
}

fn lower_bound(a: &[i64], mut low: isize, mut high: isize, key: i64) -> isize {
    while low < high {
        let mid = low + (high - low) / 2;

        match key.cmp(&a[mid as usize]) {
            Ordering::Greater => low = mid + 1,
            _ => high = mid,
        }
    }

    if a[low as usize] == key {
        low
    } else {
        -1
    }
}

fn main() {
    let n = get_num();
    let a = get_nums();
    let _q = get_num();
    let qs = get_nums();

    for q in qs {
        print!("{} ", lower_bound(&a, 0, (n - 1) as isize, q));
    }
    println!();
}