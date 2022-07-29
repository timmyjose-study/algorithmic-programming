use std::io;

fn get_num() -> i32 {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");
    input.trim().parse::<_>().unwrap()
}

fn fibonacci_last_digit(n: i32) -> i32 {
    if n == 0 || n == 1 {
        return n;
    }

    let mut f = Vec::with_capacity((n + 1) as usize);

    for _ in 0..=n as usize {
        f.push(0);
    }

    f[0] = 0;
    f[1] = 1;

    for i in 2..=n as usize {
        f[i] = (f[i - 1] % 10 + f[i - 2] % 10) % 10;
    }

    f[n as usize]
}

fn main() {
    let n = get_num();
    println!("{}", fibonacci_last_digit(n));
}