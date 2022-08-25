use std::io;

fn get_num() -> u64 {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    input.trim().parse::<u64>().unwrap()
}

// O(n) / O(n)
fn fibonacci(m: u64) -> u64 {
    match m {
        0 => 0,
        1 => 1,
        _ => {
            let mut dp = vec![0; (m + 1) as usize];

            dp[0] = 0;
            dp[1] = 1;
            for i in 2..=m as usize {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            dp[m as usize]
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