use std::collections::HashMap;
use std::io;

fn get_num() -> u64 {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    input.trim().parse::<u64>().unwrap()
}

fn fibonacci(m: u64) -> u64 {
    let mut memo = HashMap::new();
    fibonacci_memo(m, &mut memo)
}

fn fibonacci_memo(m: u64, memo: &mut HashMap<u64, u64>) -> u64 {
    match m {
        0 => {
            memo.entry(0).or_insert(0);
            0
        }

        1 => {
            memo.entry(1).or_insert(1);
            1
        }
        _ => {
            if memo.contains_key(&m) {
                *memo.get(&m).unwrap()
            } else {
                let fval = fibonacci_memo(m - 1, memo);
                let sval = fibonacci_memo(m - 2, memo);
                memo.insert(m, fval + sval);
                *memo.get(&m).unwrap()
            }
        }
    }
}

fn main() {
    let n = get_num();

    for _ in 0..n {
        let m = get_num();
        println!("{}", fibonacci(m));
    }
}