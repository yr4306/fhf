import java.util.*;

class Book {
    int id;
    String title;
    String genre;

    Book(int id, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public String toString() {
        return id + ": " + title + " (" + genre + ")";
    }
}

class LibrarySystem {
    private List<Book> bookList = new ArrayList<>();
    private Set<String> genres = new HashSet<>();
    private Map<Integer, Book> bookMap = new HashMap<>();

    void addBook(Book b) {
        bookList.add(b);
        genres.add(b.genre);
        bookMap.put(b.id, b);
    }

    // 按ID删除（使用Iterator同步删除）
    boolean removeBookById(int id) {
        Book b = bookMap.remove(id);
        if (b == null) return false;
        Iterator<Book> it = bookList.iterator();
        while (it.hasNext()) {
            if (it.next().id == id) {
                it.remove();
                break;
            }
        }
        // 更新流派集合
        genres.clear();
        for (Book book : bookList) genres.add(book.genre);
        return true;
    }

    // 按标题搜索（返回匹配的图书列表）
    List<Book> searchByTitle(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book b : bookList) {
            if (b.title.contains(keyword)) result.add(b);
        }
        return result;
    }

    void displayStatus() {
        System.out.println("图书列表: " + bookList);
        System.out.println("流派集合: " + genres);
        System.out.println("ID映射: " + bookMap.keySet());
    }
}