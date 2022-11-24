use actix_web::{post, web, App, HttpServer, Responder};

pub mod trie {
    use std::collections::HashMap;

    pub struct Trie {
        root: TrieNode,
    }

    impl Trie {
        pub fn new() -> Self {
            Trie {
                root: TrieNode::new(),
            }
        }

        pub fn insert(&mut self, word: String) {
            let mut curr = &mut self.root;

            for c in word.chars() {
                let next = curr.children.entry(c).or_insert(TrieNode::new());
                curr = next;
            }
            curr.is_word_end = true;
        }

        pub fn search(&self, word: &str) -> bool {
            let mut curr = &self.root;

            for c in word.chars() {
                if let Some(next) = curr.children.get(&c) {
                    curr = next;
                } else {
                    return false;
                }
            }

            curr.is_word_end
        }
    }

    struct TrieNode {
        pub is_word_end: bool,
        pub children: HashMap<char, TrieNode>,
    }

    impl TrieNode {
        pub fn new() -> Self {
            TrieNode {
                is_word_end: false,
                children: HashMap::new(),
            }
        }
    }
}

use std::{
    fs::File,
    io::{BufRead, BufReader},
};

const DICT_PATH: &'static str = "/usr/share/dict/words";

pub fn init_dict_trie() -> Result<trie::Trie, std::io::Error> {
    let reader = BufReader::new(File::open(DICT_PATH)?);
    let mut trie = trie::Trie::new();

    for line in reader.lines() {
        let line = line.unwrap().trim().to_owned();
        trie.insert(line);
    }

    Ok(trie)
}

pub fn play_game(input: Vec<String>) -> Vec<String> {
    let trie = init_dict_trie().unwrap();
    let mut res = Vec::new();

    for word1 in &input {
        for word2 in &input {
            for word3 in &input {
                for i in 0..word1.len() - 1 {
                    for j in 1..word2.len() - 1 {
                        for k in 1..word3.len() {
                            let comp1 = &word1[0..i];
                            let comp2 = &word2[1..j];
                            let comp3 = &word3[1..k + 1];

                            if comp1.len() >= 1 && comp1.len() >= 1 && comp3.len() >= 1 {
                                let check_word = format!("{}{}{}", comp1, comp2, comp3);

                                if check_word.len() > 1 {
                                    if trie.search(&check_word) {
                                        res.push(check_word);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    res
}

#[post("/words")]
async fn words(req_body: web::Json<Vec<String>>) -> impl Responder {
    web::Json(play_game(req_body.to_vec()))
}

#[actix_web::main]
async fn main() -> std::io::Result<()> {
    HttpServer::new(|| App::new().service(words))
        .bind(("localhost", 9999))?
        .run()
        .await
}
