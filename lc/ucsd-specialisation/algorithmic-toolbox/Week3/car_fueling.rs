use std::io;

fn get_num() -> i32 {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");
    input.trim().parse::<_>().unwrap()
}

fn get_nums() -> Vec<i32> {
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

fn min_stops(d: i32, m: i32, n: usize, ds: &Vec<i32>) -> i32 {
    let mut stops = 0;
    let mut curr_loc = 0;

    loop {
        if ds[curr_loc] + m >= d {
            break;
        }

        let mut adv = curr_loc;
        while adv <= n && (ds[curr_loc] + m >= ds[adv]) {
            adv += 1;
        }
        adv -= 1;

        if curr_loc != adv {
            curr_loc = adv;
        }

        stops += 1;

        if ds[curr_loc] + m < ds[curr_loc + 1] {
            return -1;
        }
    }

    stops
}

fn main() {
    let d = get_num();
    let m = get_num();
    let n = get_num();

    let mut ds = get_nums();
    ds.insert(0, 0);
    ds.push(d);

    println!("{}", min_stops(d, m, n as usize, &ds));
}