#!/usr/bin/env bash

gitmodules="$(git config --file .gitmodules --list)"

mapfile -t submodules < <(echo "$gitmodules" | cut -d '=' -f 1 | cut -d '.' -f 2 | uniq)

get_field() {
    echo "$gitmodules" | grep "$submodule\.$1" | cut -d '=' -f 2
}

for submodule in "${submodules[@]}"; do
    path="$(get_field path)"
    url="$(get_field url)"
    branch="$(get_field branch)"
    git submodule add -b "$branch" "$url" "$path"
done
