let filename = "log.txt"

let read () =
  let lines = ref [] in
  let file = open_in filename in
  try
    while true do
      let line = input_line file in
      let fields = String.split_on_char '\n' line in
      lines := fields :: !lines
    done; !lines
  with End_of_file -> close_in file; List.rev !lines;;

let x = read();;
