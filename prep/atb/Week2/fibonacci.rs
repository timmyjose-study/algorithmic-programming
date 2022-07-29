use std::io;

fn get_num() -> usize {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");

    input.trim().parse::<_>().unwrap()
}

fn fibonacci(n: usize) -> usize {
    let mut f = Vec::with_capacity(n);

    if n == 0 || n == 1 {
        return n;
    }

    for _ in 0..=n {
        f.push(0);
    }

    f[0] = 0;
    f[1] = 1;

    for i in 2..=n {
        f[i] = f[i - 1] + f[i - 2];
    }

    f[n]
}

fn main() {
    let n = get_num();
    println!("{}", fibonacci(n));
}