use std::io;

fn get_nums() -> (i64, i64) {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");

    let nums = input
        .trim()
        .split_whitespace()
        .map(|d| d.parse::<i64>().unwrap())
        .collect::<Vec<_>>();

    (nums[0].clone(), nums[1].clone())
}

fn gcd(mut n: i64, mut m: i64) -> i64 {
    while m != 0 {
        let t = n % m;
        n = m;
        m = t;
    }
    n
}

fn lcm(n: i64, m: i64) -> i64 {
    let prod = (n as i64) * (m as i64);
    (prod / gcd(n, m) as i64) as i64
}

fn main() {
    let (n, m) = get_nums();
    println!("{}", lcm(n, m));
}