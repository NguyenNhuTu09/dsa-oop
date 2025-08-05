package com.example.DesignPatterns;

// Bài toán:
// Một hệ thống kiểm duyệt nội dung cần xử lý các yêu cầu đăng bài viết. Mỗi bài viết cần được kiểm tra qua các bước:

// Kiểm tra ngôn ngữ xấu: Loại bỏ các bài viết chứa từ ngữ không phù hợp.
// Kiểm tra độ dài: Loại bỏ các bài viết quá ngắn (dưới 10 ký tự).
// Kiểm tra nội dung quảng cáo: Loại bỏ các bài viết chứa nội dung quảng cáo không mong muốn.
// Nếu bài viết vượt qua tất cả các bước kiểm duyệt, nó sẽ được chấp nhận.

// Abstract Handler
abstract class ContentFilter {
    protected ContentFilter nextFilter;

    public void setNextFilter(ContentFilter nextFilter) {
        this.nextFilter = nextFilter;
    }

    public abstract boolean handle(String content);
}

// Concrete Handler: Bad Language Filter
class BadLanguageFilter extends ContentFilter {
    @Override
    public boolean handle(String content) {
        if (content.contains("badword")) {
            System.out.println("Rejected: Contains inappropriate language.");
            return false;
        }
        if (nextFilter != null) {
            return nextFilter.handle(content);
        }
        return true;
    }
}

// Concrete Handler: Length Filter
class LengthFilter extends ContentFilter {
    @Override
    public boolean handle(String content) {
        if (content.length() < 10) {
            System.out.println("Rejected: Content is too short.");
            return false;
        }
        if (nextFilter != null) {
            return nextFilter.handle(content);
        }
        return true;
    }
}

// Concrete Handler: Advertisement Filter
class AdvertisementFilter extends ContentFilter {
    @Override
    public boolean handle(String content) {
        if (content.contains("Buy now") || content.contains("Visit our site")) {
            System.out.println("Rejected: Contains advertisement.");
            return false;
        }
        if (nextFilter != null) {
            return nextFilter.handle(content);
        }
        return true;
    }
}

public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        // Create filters
        ContentFilter badLanguageFilter = new BadLanguageFilter();
        ContentFilter lengthFilter = new LengthFilter();
        ContentFilter advertisementFilter = new AdvertisementFilter();

        // Set up the chain
        badLanguageFilter.setNextFilter(lengthFilter);
        lengthFilter.setNextFilter(advertisementFilter);

        // Test content moderation
        String[] posts = {
            "This is a clean post.",
            "badword in this post.",
            "Short.",
            "Buy now and get 50% off!",
            "This post is perfect and clean."
        };

        for (String post : posts) {
            System.out.println("Processing post: \"" + post + "\"");
            boolean result = badLanguageFilter.handle(post);
            if (result) {
                System.out.println("Accepted: Post is approved.\n");
            } else {
                System.out.println("Rejected: Post did not pass moderation.\n");
            }
        }
    }
}
