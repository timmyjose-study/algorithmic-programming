use std::io;

fn get_num() -> u64 {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    input.trim().parse::<u64>().unwrap()
}

fn fibonacci(m: u64) -> u64 {
    match m {
        0 => 0,
        1 => 1,
        _ => fibonacci(m - 1) + fibonacci(m - 2),
    }
}

fn main() {
    let n = get_num();

    for _ in 0..n {
        let m = get_num();
        println!("{}", fibonacci(m));
    }
}