use std::io;

fn get_num() -> i32 {
    let mut input = String::new();

    match io::stdin().read_line(&mut input) {
        Ok(n) => {
            if n == 0 {
                -1
            } else {
                input.trim().parse::<i32>().unwrap()
            }
        }
        Err(_) => -1,
    }
}

fn get_string() -> String {
    let mut input = String::new();

    io::stdin().read_line(&mut input).unwrap();
    input.trim().to_owned()
}

fn rabin_karp(s: String, t: String) -> Vec<usize> {
    let m = 53i64;
    let p = 1e9 as i64 + 7;
    let slen = s.len();
    let tlen = t.len();

    if slen > tlen {
        return vec![];
    }

    let mut ppow = Vec::with_capacity(std::cmp::max(slen, tlen));
    for _ in 0..ppow.capacity() {
        ppow.push(0);
    }

    ppow[0] = 1;
    for i in 1..ppow.len() {
        ppow[i] = (ppow[i - 1] * p) % m;
    }

    let mut shash = 0i64;
    for (idx, elem) in s.bytes().enumerate() {
        shash = (shash + (elem as i64 - b'a' as i64 + 1) * ppow[idx]) % m;
    }

    if shash < 0 {
        shash += m;
    }

    let mut thashes = Vec::with_capacity(tlen + 1);
    for _ in 0..tlen + 1 {
        thashes.push(0);
    }

    for (idx, elem) in t.bytes().enumerate() {
        thashes[idx + 1] = (thashes[idx] + (elem as i64 - b'a' as i64 + 1) * ppow[idx]) % m;
    }

    for thash in thashes.iter_mut() {
        if *thash < 0 {
            *thash += m;
        }
    }

    let mut occurrences = Vec::new();
    for curr_idx in 0..tlen - slen + 1 {
        let curr_hash = (thashes[curr_idx + slen] - thashes[curr_idx] + m) % m;

        if curr_hash == shash * ppow[curr_idx] % m {
            occurrences.push(curr_idx);
        }
    }

    occurrences
}

fn main() {
    loop {
        let n = get_num();

        if n == -1 {
            break;
        }
        let s = get_string();
        let t = get_string();

        let positions = rabin_karp(s, t);
        if positions.is_empty() {
            println!();
            println!();
        } else {
            for pos in positions {
                println!("{}", pos);
            }
        }
    }
}