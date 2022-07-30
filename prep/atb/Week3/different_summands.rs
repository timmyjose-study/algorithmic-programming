use std::io;

fn get_num() -> i32 {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");

    input.trim().parse::<_>().unwrap()
}

fn different_summands(n: i32) {
    let mut k = 0;

    while (k * (k + 1)) / 2 <= n {
        k += 1;
    }
    k -= 1;

    println!("{}", k);

    for d in 1..k {
        print!("{} ", d);
    }

    println!("{}", n - (k - 1) * k / 2);
}

fn main() {
    let n = get_num();
    different_summands(n);
}