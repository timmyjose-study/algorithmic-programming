use std::cmp::max;
use std::io;

fn get_num() -> i32 {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read number");
    input.trim().parse::<_>().unwrap()
}

fn get_string() -> String {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read string");
    input.trim().to_owned()
}

fn rabin_karp(s: &str, t: &str) -> Vec<usize> {
    let m = 53;
    let p = 1000000009;

    let slen = s.len();
    let tlen = t.len();

    let mut ppow = vec![0; max(slen, tlen)];

    ppow[0] = 1;
    for i in 1..ppow.len() {
        ppow[i] = (ppow[i - 1] * p) % m;
    }

    let mut shash = 0;
    for (i, b) in s.bytes().enumerate() {
        shash = (shash + (b - b' ' + 1) as i64 * ppow[i]) % m;
    }

    let mut thashes = vec![0; tlen + 1];
    for (i, b) in t.bytes().enumerate() {
        thashes[i + 1] = (thashes[i] + (b - b' ' + 1) as i64 * ppow[i]) % m;
    }

    let mut occurrences = Vec::new();
    for i in 0..tlen - slen + 1 {
        let curr_hash = (thashes[i + slen] + m - thashes[i]) % m;

        if curr_hash == shash * ppow[i] % m {
            occurrences.push(i);
        }
    }

    occurrences
}

fn main() {
    let n = get_num();

    for _ in 0..n {
        let s = get_string();
        let t = get_string();

        let res = rabin_karp(&s, &t);
        println!("s = {s}, t = {t}");

        if res.is_empty() {
            println!("-1");
        } else {
            println!("{}", res.len());
            for pos in res {
                print!("{} ", pos);
            }
            println!();
        }
    }
}