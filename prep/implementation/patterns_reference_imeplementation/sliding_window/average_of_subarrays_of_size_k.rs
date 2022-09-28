use std::io;

fn get_pair() -> (i32, i32) {
    let mut input = String::new();

    io::stdin().read_line(&mut input).unwrap();
    let v = input
        .trim()
        .split_whitespace()
        .map(|d| d.parse::<i32>().unwrap())
        .collect::<Vec<_>>();

    (v[0].clone(), v[1].clone())
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

fn get_string() -> String {
    let mut input = String::new();

    io::stdin().read_line(&mut input).unwrap();
    input.trim().to_owned()
}

fn get_num() -> i32 {
    let mut input = String::new();

    io::stdin().read_line(&mut input).unwrap();
    input.trim().parse::<i32>().unwrap()
}

fn main() {
    let (n, k) = get_pair();
    let a = get_nums();

    let mut sum = 0.0;
    let mut window_start = 0usize;
    let mut window_end = 0usize;
    let mut res = Vec::with_capacity(n as usize - k as usize + 1);

    while window_end < n as usize {
        sum += a[window_end] as f64;

        if window_end >= k as usize - 1 {
            res.push(sum / (k as f64));
            sum -= a[window_start] as f64;
            window_start += 1;
        }
        window_end += 1;
    }

    for r in res {
        print!("{:.2} ", r);
    }
    println!();
}