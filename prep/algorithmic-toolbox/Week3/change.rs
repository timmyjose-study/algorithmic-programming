use std::io;

fn get_num() -> i32 {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");

    input.trim().parse::<_>().unwrap()
}

fn min_coins(mut amount: i32, coins: &mut [i32; 3]) -> i32 {
    let mut m = 0;

    coins.sort_by(|x, y| y.cmp(&x));

    while amount != 0 {
        for c in coins.iter() {
            if *c <= amount {
                m += amount / *c;
                amount %= *c;
                break;
            }
        }
    }
    m
}

fn main() {
    let n = get_num();
    let mut coins = [1, 5, 10];
    println!("{}", min_coins(n, &mut coins));
}