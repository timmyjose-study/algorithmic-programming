use std::io;

fn get_string() -> String {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    input.trim().to_owned()
}

fn main() {
    let s = get_string();

    let is_vowel = |c| match c {
        'a' | 'A' | 'e' | 'E' | 'i' | 'I' | 'o' | 'O' | 'u' | 'U' | 'y' | 'Y' => true,
        _ => false,
    };

    if is_vowel(s.chars().nth(2).unwrap()) {
        println!("invalid");
        return;
    }

    let s01 = s.chars().nth(0).unwrap().to_digit(10).unwrap()
        + s.chars().nth(1).unwrap().to_digit(10).unwrap();
    let s34 = s.chars().nth(3).unwrap().to_digit(10).unwrap()
        + s.chars().nth(4).unwrap().to_digit(10).unwrap();
    let s45 = s.chars().nth(4).unwrap().to_digit(10).unwrap()
        + s.chars().nth(5).unwrap().to_digit(10).unwrap();
    let s78 = s.chars().nth(7).unwrap().to_digit(10).unwrap()
        + s.chars().nth(8).unwrap().to_digit(10).unwrap();

    if s01 % 2 != 0 || s34 % 2 != 0 || s45 % 2 != 0 || s78 % 2 != 0 {
        println!("invalid");
    } else {
        println!("valid");
    }
}