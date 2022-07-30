use std::io;

fn get_pair() -> (i32, i32) {
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("failed to read input");

    let nums = input
        .trim()
        .split_whitespace()
        .map(|d| d.parse::<i32>().unwrap())
        .collect::<Vec<_>>();

    (nums[0].clone(), nums[1].clone())
}

fn fractional_knapsack(mut capacity: i32, items: &mut Vec<(i32, i32)>) -> f64 {
    items.sort_by(|p, q| {
        let pval = (p.0 as f64) / (p.1 as f64);
        let qval = (q.0 as f64) / (q.1 as f64);

        qval.partial_cmp(&pval).unwrap()
    });

    let mut value = 0.0;
    for item in items.iter() {
        if capacity == 0 {
            break;
        }

        let item_weight = capacity.min(item.1);
        value += (item_weight as f64 * item.0 as f64) / (item.1 as f64);
        capacity -= item_weight;
    }

    value
}

fn main() {
    let (n, capacity) = get_pair();
    let mut items = Vec::with_capacity(n as usize);

    for _ in 0..n {
        items.push(get_pair());
    }

    println!("{:.5}", fractional_knapsack(capacity, &mut items));
}