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

fn string_hash(s: &str) -> i64 {
    let p = 53;
    let m = 1000000009;

    let mut ppow = 1;
    let mut hash_val = 0;

    for b in s.bytes() {
        hash_val = (hash_val + (b - b' ' + 1) as i64 * ppow) % m;
        ppow = (ppow * p) % m;
    }

    hash_val
}

fn main() {
    let n = get_num();

    for _ in 0..n {
        let s = get_string();
        println!("hash({})= {}", s, string_hash(&s));
    }
}