use std::io;

fn get_num() -> usize {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");
    input.trim().parse::<_>().unwrap()
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

fn fibonacci_sum(n: usize) -> usize {
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

    f[n % period]
}

fn main() {
    let n = get_num();
    println!("{}", fibonacci_sum(n));
}