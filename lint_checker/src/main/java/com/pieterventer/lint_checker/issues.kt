@file:Suppress("UnstableApiUsage")

package com.pieterventer.lint_checker

import com.android.tools.lint.detector.api.*

val stringLiteralIssue = Issue.create(
    id = "StringLiteralIssue",
    briefDescription = "Example issue for a sensitive string used",
    explanation = "Example for a string resource being used and it shouldn't be, perhaps an api key or any other value",
    category = Category.CORRECTNESS,
    priority = 10,
    severity = Severity.ERROR,
    implementation = Implementation(
        StringResourceDetector::class.java,
        Scope.JAVA_FILE_SCOPE
    )
)

val integerLiteralIssue = Issue.create(
    id = "IntegerLiteralIssue",
    briefDescription = "Example issue for a sensitive integer used",
    explanation = "Same as the string example but makes use of converting values to string to determine if they are an incorrect integer value",
    category = Category.CORRECTNESS,
    priority = 10,
    severity = Severity.ERROR,
    implementation = Implementation(
        IntegerResourceDetector::class.java,
        Scope.JAVA_FILE_SCOPE
    )
)

val variableLengthIssue = Issue.create(
    id = "Variable length issue",
    briefDescription = "Variables should be descriptive and contain more than just 3 characters",
    explanation = "Variable names should be descriptive, 1 or 2 letters doesn't tell anyone what they're meant for, you can do better than that !!!!",
    category = Category.CORRECTNESS,
    priority = 10,
    severity = Severity.ERROR,
    implementation = Implementation(
        VariableLengthDetector::class.java,
        Scope.JAVA_FILE_SCOPE
    )
)

val functionLengthIssue = Issue.create(
    id = "Function length issue",
    briefDescription = "Functions should be descriptive and contain more than 5 letters",
    explanation = "Function names should be meaningful and descriptive, try to use more than 5 characters when naming a function",
    category = Category.CORRECTNESS,
    priority = 10,
    severity = Severity.ERROR,
    implementation = Implementation(
        FunctionLengthDetector::class.java,
        Scope.JAVA_FILE_SCOPE
    )
)

val outdatedVariableConventionIssue = Issue.create(
    id = "Variable naming convention issue",
    briefDescription = "Don't start variables with the letter \'m\' - there's no need.",
    explanation = "I'm tired of typing \'m\' when I have to find a variable, stop doing it !!!!!",
    category = Category.CORRECTNESS,
    priority = 10,
    severity = Severity.ERROR,
    implementation = Implementation(
        OutdatedVariableConventionDetector::class.java,
        Scope.JAVA_FILE_SCOPE
    )
)
