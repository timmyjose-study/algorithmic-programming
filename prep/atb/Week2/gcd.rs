use std::io;

fn get_nums() -> (i32, i32) {
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

fn gcd(mut n: i32, mut m: i32) -> i32 {
    while m != 0 {
        let t = n % m;
        n = m;
        m = t;
    }
    n
}

fn main() {
    let (n, m) = get_nums();
    println!("{}", gcd(n, m));
}