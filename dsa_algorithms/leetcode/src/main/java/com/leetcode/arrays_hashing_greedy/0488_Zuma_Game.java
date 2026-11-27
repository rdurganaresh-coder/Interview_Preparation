package com.leetcode.arrays_hashing_greedy;

class Solution0488 {
    public int findMinStep(String board, String hand) {
        final Zuma0488 zuma = Zuma0488.create(board, hand);
        final HashSet<Long> visited = new HashSet<>();
        final ArrayList<Zuma0488> init = new ArrayList<>();

        visited.add(zuma.board());
        init.add(zuma);
        return bfs(init, 0, visited);
    }

    private int bfs(ArrayList<Zuma0488> curr, int k, HashSet<Long> visited) {
        if (curr.isEmpty()) {
            return -1;
        }

        final ArrayList<Zuma0488> next = new ArrayList<>();

        for (Zuma0488 zuma : curr) {
            ArrayList<Zuma0488> neib = zuma.getNextLevel(k, visited);
            if (neib == null) {
                return k + 1;
            }

            next.addAll(neib);
        }
        return bfs(next, k + 1, visited);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0488 _tcSol = new Solution0488();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "board = \"WRRBBW\", hand = \"RB\"");
        try {
            String board = "WRRBBW";
            String hand = "RB";
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinStep(board, hand)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "board = \"WWRRBBWW\", hand = \"WRBRW\"");
        try {
            String board = "WWRRBBWW";
            String hand = "WRBRW";
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinStep(board, hand)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "board = \"G\", hand = \"GGGGG\"");
        try {
            String board = "G";
            String hand = "GGGGG";
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinStep(board, hand)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}

record Zuma0488(long board, long hand) {
    public static Zuma0488 create(String boardStr, String handStr) {
        return new Zuma0488(Zuma0488.encode(boardStr, false), Zuma0488.encode(handStr, true));
    }

    public ArrayList<Zuma0488> getNextLevel(int depth, HashSet<Long> visited) {
        final ArrayList<Zuma0488> next = new ArrayList<>();
        final ArrayList<long[]> handList = this.buildHandList();
        final long[] boardList = new long[32];
        final int size = this.buildBoardList(boardList);

        for (long[] pair : handList) {
            for (int i = 0; i < size; ++i) {
                final long rawBoard = pruningCheck(boardList[i], pair[0], i * 3, depth);
                if (rawBoard == -1) {
                    continue;
                }

                final long nextBoard = updateBoard(rawBoard);
                if (nextBoard == 0) {
                    return null;
                }

                if (pair[1] == 0 || visited.contains(nextBoard)) {
                    continue;
                }

                visited.add(nextBoard);
                next.add(new Zuma0488(nextBoard, pair[1]));
            }
        }
        return next;
    }

    private long pruningCheck(long insBoard, long ball, int pos, int depth) {
        final long L = (insBoard >> (pos + 3)) & 0x7;
        final long R = (insBoard >> (pos - 3)) & 0x7;

        if (depth == 0 && (ball != R) && (L != R) || depth > 0 && (ball != R)) {
            return -1;
        }
        return insBoard | (ball << pos);
    }

    private long updateBoard(long board) {
        long stack = 0;

        for (int i = 0; i < 64; i += 3) {
            final long curr = (board >> i) & 0x7;
            final long top = (stack) &0x7;

            // pop (if possible)
            if ((top > 0) && (curr != top) && (stack & 0x3F) == ((stack >> 3) & 0x3F)) {
                stack >>= 9;
                if ((stack & 0x7) == top) stack >>= 3;
            }

            if (curr == 0) {
                // done
                break;
            }
            // push and continue
            stack = (stack << 3) | curr;
        }
        return stack;
    }

    private ArrayList<long[]> buildHandList() {
        final ArrayList<long[]> handList = new ArrayList<>();
        long prevBall = 0;
        long ballMask = 0;

        for (int i = 0; i < 16; i += 3) {
            final long currBall = (this.hand >> i) & 0x7;
            if (currBall == 0) {
                break;
            }

            if (currBall != prevBall) {
                prevBall = currBall;
                handList.add(
                    new long[] {currBall, ((this.hand >> 3) & ~ballMask) | (this.hand & ballMask)});
            }
            ballMask = (ballMask << 3) | 0x7;
        }
        return handList;
    }

    private int buildBoardList(long[] buffer) {
        int ptr = 0;
        long ballMask = 0x7;
        long insBoard = this.board << 3;
        buffer[ptr++] = insBoard;

        while (true) {
            final long currBall = this.board & ballMask;
            if (currBall == 0) {
                break;
            }

            ballMask <<= 3;
            insBoard = (insBoard | currBall) & ~ballMask;
            buffer[ptr++] = insBoard;
        }
        return ptr;
    }

    private static long encode(String stateStr, boolean sortFlag) {
        final char[] stateChars = stateStr.toCharArray();
        if (sortFlag) {
            Arrays.sort(stateChars);
        }

        long stateBits = 0;
        for (char ch : stateChars) {
            stateBits = (stateBits << 3) | Zuma0488.encode(ch);
        }
        return stateBits;
    }

    private static long encode(char ch) {
        return switch (ch) {
            case 'R' -> 0x1;
            case 'G' -> 0x2;
            case 'B' -> 0x3;
            case 'W' -> 0x4;
            case 'Y' -> 0x5;
            case ' ' -> 0x0;
            default  ->
                throw new IllegalArgumentException("Invalid char: " + ch);
        };
    }
}
