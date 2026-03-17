#!/bin/bash
# Extract detailed test failure information from Surefire reports

REPORT_DIR="target/surefire-reports"

if [ ! -d "$REPORT_DIR" ]; then
    echo "No test reports found"
    exit 0
fi

echo "=== Failed Tests Details ==="
echo ""

# Find all test report files
for file in $REPORT_DIR/TEST-*.xml; do
    if [ -f "$file" ]; then
        # Extract failures and errors
        grep -A 10 '<failure\|<error' "$file" | while IFS= read -r line; do
            if [[ $line =~ name=\"([^\"]+)\" ]]; then
                TEST_NAME="${BASH_REMATCH[1]}"
                echo "❌ $TEST_NAME"
            elif [[ $line =~ message=\"([^\"]+)\" ]]; then
                MESSAGE="${BASH_REMATCH[1]}"
                echo "   Reason: $MESSAGE"
                echo ""
            fi
        done
    fi
done
