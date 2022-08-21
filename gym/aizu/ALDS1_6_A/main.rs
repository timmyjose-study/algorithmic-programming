use std::io;

fn get_num() -> usize {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    input.trim().parse::<_>().unwrap()
}

fn get_nums() -> Vec<i32> {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();

    input
        .trim()
        .split_whitespace()
        .map(|d| d.parse::<i32>().unwrap())
        .collect::<Vec<_>>()
}

fn sort(a: &mut [i32], mn: i32, mx: i32) {
    let k = (mx - mn + 1) as usize;
    let mut freq = vec![0; k];

    for e in a.iter() {
        freq[(*e - mn) as usize] += 1;
    }

    let mut idx = 0;
    let mut elem = 0;

    for f in &freq {
        for _ in 0..*f {
            a[idx] = elem + mn;
            idx += 1;
        }
        elem += 1;
    }
}

fn display(a: &[i32], n: usize) {
    for i in 0..n - 1 {
        print!("{} ", a[i]);
    }
    println!("{}", a[n - 1]);
}

fn main() {
    let n = get_num();
    let mut a = get_nums();

    let mn = {
        let tmp_mn = a.iter_mut().min().unwrap();
        *tmp_mn
    };

    let mx = {
        let tmp_mx = a.iter_mut().max().unwrap();
        *tmp_mx
    };

    sort(&mut a, mn, mx);

    display(&a, n);
}