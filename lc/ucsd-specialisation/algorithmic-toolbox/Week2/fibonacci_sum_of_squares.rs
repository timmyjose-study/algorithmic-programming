use std::io;

fn get_num() -> usize {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");

    input.trim().parse::<_>().unwrap()
}

fn fibonacci_sum_of_squares(n: usize) -> usize {
    let period = 30;
    let mut f = Vec::with_capacity(period + 1);

    for _ in 0..=period {
        f.push(0);
    }

    f[0] = 0;
    f[1] = 1;

    for i in 2..=period {
        f[i] = f[i - 1] + f[i - 2];
    }

    for i in 0..=period {
        f[i] *= f[i];
    }

    for i in 1..=period {
        f[i] = (f[i] % 10 + f[i - 1] % 10) % 10;
    }

    f[n % period]
}

fn main() {
    let n = get_num();
    println!("{}", fibonacci_sum_of_squares(n));
}