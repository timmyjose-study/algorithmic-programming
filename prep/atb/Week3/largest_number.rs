use std::io;

fn get_num() -> i64 {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");

    input.trim().parse::<_>().unwrap()
}

fn get_nums() -> Vec<i64> {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");

    input
        .trim()
        .split_whitespace()
        .map(|d| d.parse::<_>().unwrap())
        .collect::<Vec<_>>()
}

fn largest_number(ns: &mut Vec<i64>) -> String {
    let is_greater = |a: &i64, b: &i64| {
        let astrbstr = format!("{}{}", a, b);
        let bstrastr = format!("{}{}", b, a);

        bstrastr
            .parse::<i32>()
            .unwrap()
            .cmp(&astrbstr.parse::<i32>().unwrap())
    };

    ns.sort_by(is_greater);

    let mut maxnum = String::new();
    for n in ns {
        maxnum.push_str(&format!("{}", n));
    }

    maxnum
}

fn main() {
    let _ = get_num();
    let mut ns = get_nums();
    println!("{}", largest_number(&mut ns));
}