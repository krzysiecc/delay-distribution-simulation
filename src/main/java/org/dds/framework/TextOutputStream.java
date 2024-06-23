package org.dds.framework;

import javafx.application.Platform;
import javafx.scene.control.TextArea;
import java.io.OutputStream;

public class TextOutputStream extends OutputStream {
    private final TextArea textArea;

    public TextOutputStream(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) {
        // Redirect the data to the text area (character by character)
        Platform.runLater(() -> textArea.appendText(String.valueOf((char) b)));
    }

    @Override
    public void write(byte[] b, int off, int len) {
        // Redirect the data to the text area (array of characters)
        Platform.runLater(() -> textArea.appendText(new String(b, off, len)));
    }
}

