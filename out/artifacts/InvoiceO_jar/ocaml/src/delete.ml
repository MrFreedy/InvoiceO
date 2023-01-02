let trash_file = "log.txt";;
let delete=
  try
    Sys.remove trash_file
  with Sys_error _ ->
    print_endline ("Erreur : impossible de supprimer le fichier " ^ trash_file)