let filename = "logs.csv"

let write message =
  let output_channel = open_out_gen [Open_creat; Open_append] 0o640 filename in
  List.iter (fun inner_list ->
    let line = String.concat "," inner_list in
    output_string output_channel (line ^ "\n");
  ) message;
  close_out output_channel

