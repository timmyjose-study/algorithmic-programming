use std::io;

fn get_nums() -> (usize, usize) {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");

    let nums = input
        .trim()
        .split_whitespace()
        .map(|d| d.parse::<usize>().unwrap())
        .collect::<Vec<_>>();

    (nums[0].clone(), nums[1].clone())
}

fn pisano_period(m: usize) -> usize {
    let mut a = 0;
    let mut b = 1;
    let mut c;
    let mut period = 2;

    loop {
        c = a;
        a = b % m;
        b = (c % m + b % m) % m;

        if a == 0 && b == 1 {
            break;
        }

        period += 1;
    }

    period - 1
}

fn fibonacci_partial_sum(n: usize, m: usize) -> usize {
    let period = pisano_period(10);

    let mut f = Vec::with_capacity(period + 1);
    for _ in 0..=period {
        f.push(0);
    }

    f[0] = 0;
    f[1] = 1;
    for i in 2..=period {
        f[i] = (f[i - 1] % 10 + f[i - 2] % 10) % 10;
    }

    for i in 1..=period {
        f[i] = (f[i] % 10 + f[i - 1] % 10) % 10;
    }

    let from = n % period;
    let to = m % period;

    if from == 0 {
        f[to]
    } else {
        if f[to] < f[from - 1] {
            f[to] + 10 - f[from - 1]
        } else {
            f[to] - f[from - 1]
        }
    }
}

fn main() {
    let (n, m) = get_nums();
    println!("{}", fibonacci_partial_sum(n, m));
}