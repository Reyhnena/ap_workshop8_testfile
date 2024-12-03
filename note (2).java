public static void displayNoteTitles(Scanner scanner) {
    if (notes.isEmpty()) {
        System.out.println("No notes available.");
        return;
    }
    int index = 0;
    for (Note note : notes) {
        System.out.println((index++) + " - " + note.getTitle());
    }
    System.out.println("-----------");
    System.out.print("Enter the title of your note: ");
    String title = scanner.nextLine();
    Note note = findNoteByTitle(title);
    System.out.println(note.showNote());
    System.out.println("------------");
}

private static void exportNoteToFile(Scanner scanner){
    System.out.print("Enter the title of your note: ");
    String title = scanner.nextLine();
    Note note = findNoteByTitle(title);
    String fileName = title + ".txt";
    try (FileWriter writer = new FileWriter(fileName)) {
        writer.write(note.getText());
    } catch (IOException e) {
        System.err.println(e.getMessage());
    }
}

private static void displayMenu() {
    System.out.println();
    System.out.println("---------Notepad---------");
    System.out.println("1 - Add a new note");
    System.out.println("2 - Show all notes");
    System.out.println("3 - Export a note");
    System.out.println("4 - Remove a note");
    System.out.println("5 - Exit");
    System.out.print("Enter your choice: ");
    processUserChoice();
}

private static void processUserChoice() {
    Scanner scanner = new Scanner(System.in);
    int choice = scanner.nextInt();
    scanner.nextLine();
    switch (choice) {
        case 1:
            addNote(scanner);
            break;
        case 2:
            displayNoteTitles(scanner);
            break;
        case 3:
            exportNoteToFile(scanner);
            break;
        case 4:
            removeNote(scanner);
            break;
        case 5:
            saveNotes();
            System.out.println("Goodbye!");
            System.exit(0);
            break;
        default:
            System.out.println("Invalid input! Please try again.");
    }
}