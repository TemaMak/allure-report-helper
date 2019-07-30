package temamak.qa.allure;

import io.qameta.allure.Allure;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class AllureReportDescriptionHelper {

    /**
     * Add 'topic' to description part of allure-report.
     * <p>
     * 'Topic' - unit of information with pre-formatted header
     *
     * @param topicName
     * @param topicLines
     */
    public static void appendTopicToDescription(String topicName, List<String> topicLines) {
        String appendPlainString = topicName + "\r\n" + StringUtils.join(topicLines, "\r\n");
        String appendHTMLString = "<u>" + topicName + "</u><br>" + StringUtils.join(topicLines, "<br>");

        appendToPlainDescription(appendPlainString);
        appendToHTMLDescription(appendHTMLString);

    }

    /**
     * Add 'topic' to description part of allure-report.
     * <p>
     * 'Topic' - unit of information with pre-formatted header
     *
     * @param topicName
     * @param text
     */
    public static void appendTopicToDescription(String topicName, String text) {
        String appendPlainString = topicName + "\r\n" + text;
        String appendHTMLString = "<u>" + topicName + "</u><br>" + text;

        appendToPlainDescription(appendPlainString);
        appendToHTMLDescription(appendHTMLString);

    }

    /**
     * Add some text to descriptionHTML
     *
     * @param appendText
     */
    public static void appendToHTMLDescription(String appendText) {
        Allure.getLifecycle().updateTestCase(executable -> executable.setDescriptionHtml(
                (executable.getDescriptionHtml() != null) ?
                        (executable.getDescriptionHtml() + "<br><br>" + appendText)
                        : "" + appendText)
        );

    }

    /**
     * Add some text to description
     *
     * @param appendText
     */
    public static void appendToPlainDescription(String appendText) {
        Allure.getLifecycle().updateTestCase(
                executable -> executable.setDescription(
                        (executable.getDescription() != null) ?
                                (executable.getDescription() + "\r\n\r\n" + appendText)
                                : "" + appendText
                )
        );
    }

}
