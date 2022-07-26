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
    let l = get_num();
    let n = get_num();

    for _ in 0..n {
        let (w, h) = get_pair();

        if w < l || h < l {
            println!("UPLOAD ANOTHER");
        } else if w == h {
            println!("ACCEPTED");
        } else {
            println!("CROP IT");
        }
    }
}