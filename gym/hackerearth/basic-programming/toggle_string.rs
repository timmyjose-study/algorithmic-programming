use std::io;

fn get_string() -> String {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    input.trim().to_owned()
}

fn main() {
    let s = get_string();
    let mut t = String::new();

    for c in s.chars() {
        if c.is_lowercase() {
            t.push(c.to_ascii_uppercase());
        } else {
            t.push(c.to_ascii_lowercase());
        }
    }

    println!("{}", t);
}