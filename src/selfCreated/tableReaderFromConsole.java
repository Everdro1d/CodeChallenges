package selfCreated;

import java.util.*;

import static java.util.Arrays.stream;

public class tableReaderFromConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Get the table from console
        String[][] table = parseTable(scanner);

        //Get the table data in a HashMap
        Map<String, Map<String, String>> tableMap = parseTableToMap(table);

        //Print the tableMap
        for (Map.Entry<String, Map<String, String>> entry : tableMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        scanner.close();
    }

    private static Map<String, Map<String, String>> parseTableToMap(String[][] table) {
        //Make a HashMap to store the table data
        Map<String, Map<String, String>> tableMap = new HashMap<>();

        //Iterate over rows starting from second row (index 1)
        for (int row = 1; row < table.length; row++) {
            String extValue = table[row][1];

            //Make a HashMap to store the row data
            Map<String, String> rowMap = getRowMap(table, row);

            //Put the rowMap in the tableMap with the key being the value of the EXT column
            tableMap.put(extValue, rowMap);
        }

        return tableMap;
    }

    private static Map<String, String> getRowMap(String[][] table, int row) {
        Map<String, String> rowMap = new HashMap<>();

        //Iterate over columns
        for (int column = 0; column < table[row].length; column++) {
            //Put the column data in the rowMap
            rowMap.put(table[0][column], table[row][column]);

            //Get the value from the table and put it into the rowMap
            String value = table[row][column]; // value is the value of the current cell
            String key = table[0][column];     // key is the value of the first row of the current column
            rowMap.put(key, value);            // example: rowMap.put("ID", "sb2");
        }
        return rowMap;
    }

    public static String[][] parseTable(Scanner scanner) {

        // Read the table header
        String headerString = scanner.nextLine();
        String[] headersIN = headerString.replaceAll("[│─]", "").split("\\s+");
        String[] headersOUT = stream(headersIN).filter(s -> !s.isEmpty()).toArray(String[]::new);

        //concat the 14th and 15th column headers
        headersOUT[13] = headersOUT[13] + " " + headersOUT[14];
        String[] headers = Arrays.copyOf(headersOUT, headersOUT.length - 1);

        int numColumns = Math.min(headers.length, 14);
        System.out.println(Arrays.toString(headers));

        // Create a list to store rows
        List<String[]> rows = new ArrayList<>();

        // Process each row
        while (scanner.hasNextLine()) {
            // Read the row and remove unwanted characters
            String rowString = scanner.nextLine().replaceAll("─", "").trim();
            if (rowString.isEmpty()) {
                continue;
            }


            // Split the row into cells by counting characters from the start of the headerString
            // and using the length of the headerString as the end index
            String[] row = new String[numColumns];
            for (int i = 0; i < numColumns; i++) {
                int start = headerString.indexOf(headers[i]);
                int end = start + headers[i].length();
                if ( i == numColumns - 1) {
                    end = rowString.length();
                }
                // Filesize
                if (i == 0 ) {  // ID
                    end += 1;
                } else
                if (i == 1) {  // EXT
                    end += 2;
                } else if (i == 5 || i == 6 || i == 9) { //FILESIZE, TBR
                    start -= 2;
                } else if (i == 8) {  // VCODEC
                    end += 7;
                } else if (i == 10) { // ACODEC
                    end += 4;
                } else if (i == 11) { // ABR
                    start -= 1;
                }

                if ( end > rowString.length() ) {
                    end = rowString.length();
                }
                if ( start > rowString.length()) {
                    break;
                }
                row[i] = rowString.substring(start, end).trim();
            }

            // Replace empty cells with "empty cell"
            for (int i = 0; i < numColumns; i++) {
                if (row[i] == null || row[i].isEmpty()) {
                    row[i] = "ec";
                }
            }

            System.out.println(Arrays.toString(row));
            // Add the row to the list
            rows.add(row);
        }

        // Create the 2D array
        String[][] table = new String[rows.size() + 1][numColumns];
        table[0] = Arrays.copyOf(headers, numColumns);

        // Copy the rows to the table
        for (int i = 0; i < rows.size(); i++) {
            table[i + 1] = rows.get(i);
        }
        return table;
    }

//ID EXT   RESOLUTION FPS CH │   FILESIZE  TBR PROTO │ VCODEC         VBR ACODEC      ABR ASR MORE INFO
//────────────────────────────────────────────────────────────────────────────────────────────────────────────────
//sb2 mhtml 48x27        5    │                 mhtml │ images                                 storyboard
//sb1 mhtml 60x45        1    │                 mhtml │ images                                 storyboard
//sb0 mhtml 120x90       1    │                 mhtml │ images                                 storyboard
//233 mp4   audio only        │                 m3u8  │ audio only         unknown             Default
//234 mp4   audio only        │                 m3u8  │ audio only         unknown             Default
//599 m4a   audio only      2 │   72.95KiB  31k https │ audio only         mp4a.40.5   31k 22k ultralow, m4a_dash
//600 webm  audio only      2 │   77.25KiB  33k https │ audio only         opus        33k 48k ultralow, webm_dash
//139 m4a   audio only      2 │  114.69KiB  49k https │ audio only         mp4a.40.5   49k 22k low, m4a_dash
//249 webm  audio only      2 │  109.96KiB  47k https │ audio only         opus        47k 48k low, webm_dash
//250 webm  audio only      2 │  140.42KiB  60k https │ audio only         opus        60k 48k low, webm_dash
//140 m4a   audio only      2 │  301.95KiB 130k https │ audio only         mp4a.40.2  130k 44k medium, m4a_dash
//251 webm  audio only      2 │  246.27KiB 106k https │ audio only         opus       106k 48k medium, webm_dash
//17  3gp   176x144     12  1 │  161.54KiB  69k https │ mp4v.20.3          mp4a.40.2       22k 144p
//394 mp4   192x144     15    │  133.31KiB  58k https │ av01.0.00M.08  58k video only          144p, mp4_dash
//269 mp4   192x144     15    │ ~330.90KiB 139k m3u8  │ avc1.4D400B   139k video only
//597 mp4   192x144     15    │   55.85KiB  24k https │ avc1.4d400b    24k video only          144p, mp4_dash
//160 mp4   192x144     15    │  190.56KiB  82k https │ avc1.4D400B    82k video only          144p, mp4_dash
//602 mp4   192x144     15    │ ~178.20KiB  75k m3u8  │ vp09.00.10.08  75k video only
//603 mp4   192x144     15    │ ~327.55KiB 138k m3u8  │ vp09.00.11.08 138k video only
//598 webm  192x144     15    │   49.19KiB  21k https │ vp9            21k video only          144p, webm_dash
//278 webm  192x144     15    │  180.95KiB  78k https │ vp09.00.11.08  78k video only          144p, webm_dash
//395 mp4   320x240     15    │  252.41KiB 109k https │ av01.0.00M.08 109k video only          240p, mp4_dash
//229 mp4   320x240     15    │ ~581.41KiB 245k m3u8  │ avc1.4D400C   245k video only
//133 mp4   320x240     15    │  422.66KiB 183k https │ avc1.4D400C   183k video only          240p, mp4_dash
//18  mp4   320x240     15  1 │  772.82KiB 332k https │ avc1.42001E        mp4a.40.2       44k 240p
//604 mp4   320x240     15    │ ~471.45KiB 199k m3u8  │ vp09.00.20.08 199k video only
//242 webm  320x240     15    │  286.21KiB 124k https │ vp09.00.20.08 124k video only          240p, webm_dash

}
