use std::io;

fn get_num() -> i32 {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    input.trim().parse::<_>().unwrap()
}

fn get_pair() -> (i32, i32) {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let nums = input
        .trim()
        .split_whitespace()
        .map(|d| d.parse().unwrap())
        .collect::<Vec<i32>>();
    (nums[0].clone(), nums[1].clone())
}

fn main() {
    let tt = get_num();

    let min = |n, m| if n < m { n } else { m };
    let max = |n, m| if n > m { n } else { m };

    for _ in 0..tt {
        let (g, p) = get_pair();
        let n = get_num();

        let mut fc = 0;
        let mut sc = 0;
        for _ in 0..n {
            let (f, s) = get_pair();

            if (f == 1) {
                fc += 1;
            }

            if (s == 1) {
                sc += 1;
            }
        }

        println!("{}", min(fc, sc) * max(g, p) + max(fc, sc) * min(g, p));
    }
}