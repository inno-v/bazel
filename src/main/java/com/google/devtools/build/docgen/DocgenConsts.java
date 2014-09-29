// Copyright 2014 Google Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.google.devtools.build.docgen;

import com.google.common.collect.ImmutableMap;
import com.google.devtools.build.lib.util.FileType;
import com.google.devtools.build.lib.util.FileTypeSet;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * All the constants for the Docgen project.
 */
public class DocgenConsts {

  public static final String LS = "\n";

  public static final String HEADER_TEMPLATE = "templates/be-header.html";
  public static final String FOOTER_TEMPLATE = "templates/be-footer.html";
  public static final String BODY_TEMPLATE = "templates/be-body.html";
  public static final String SKYLARK_BODY_TEMPLATE = "templates/skylark-body.html";

  public static final String VAR_LEFT_PANEL = "LEFT_PANEL";

  public static final String VAR_SECTION_BINARY = "SECTION_BINARY";
  public static final String VAR_SECTION_LIBRARY = "SECTION_LIBRARY";
  public static final String VAR_SECTION_TEST = "SECTION_TEST";
  public static final String VAR_SECTION_GENERATE = "SECTION_GENERATE";
  public static final String VAR_SECTION_OTHER = "SECTION_OTHER";

  public static final String VAR_IMPLICIT_OUTPUTS = "IMPLICIT_OUTPUTS";
  public static final String VAR_ATTRIBUTE_SIGNATURE = "ATTRIBUTE_SIGNATURE";
  public static final String VAR_ATTRIBUTE_DEFINITION = "ATTRIBUTE_DEFINITION";
  public static final String VAR_NAME = "NAME";
  public static final String VAR_HEADER_TABLE = "HEADER_TABLE";
  public static final String VAR_COMMON_ATTRIBUTE_DEFINITION = "COMMON_ATTRIBUTE_DEFINITION";
  public static final String VAR_TEST_ATTRIBUTE_DEFINITION = "TEST_ATTRIBUTE_DEFINITION";
  public static final String VAR_BINARY_ATTRIBUTE_DEFINITION = "BINARY_ATTRIBUTE_DEFINITION";
  public static final String VAR_SYNOPSIS = "SYNOPSIS";

  public static final String VAR_SECTION_SKYLARK_BUILTIN = "SECTION_BUILTIN";

  public static final String COMMON_ATTRIBUTES = "common";
  public static final String TEST_ATTRIBUTES = "test";
  public static final String BINARY_ATTRIBUTES = "binary";

  /**
   * Mark the attribute as deprecated in the Build Encyclopedia.
   */
  public static final String FLAG_DEPRECATED = "DEPRECATED";
  public static final String FLAG_GENERIC_RULE = "GENERIC_RULE";

  public static final String HEADER_COMMENT =
      "<!DOCTYPE html>\n"
      + "<!--\n"
      + " This document is synchronized with Blaze releases.\n"
      + " To edit, submit changes to the Blaze source code."
      + "-->\n";

  public static final String BUILD_ENCYCLOPEDIA_NAME = "build-encyclopedia.html";

  public static final String SKYLARK_DOC_NAME = "skylark-documentation.html";

  public static final FileTypeSet JAVA_SOURCE_FILE_SUFFIX = FileTypeSet.of(FileType.of(".java"));

  public static final String META_KEY_NAME = "NAME";
  public static final String META_KEY_TYPE = "TYPE";
  public static final String META_KEY_FAMILY = "FAMILY";

  /**
   * Types a rule can have (Binary, Library, Test or Other).
   */
  public static enum RuleType {
      BINARY, LIBRARY, TEST, OTHER
  }

  /**
   * i.e. <!-- #BLAZE_RULE(NAME = RULE_NAME, TYPE = RULE_TYPE, FAMILY = RULE_FAMILY) -->
   * i.e. <!-- #BLAZE_RULE(...)[DEPRECATED] -->
   */
  public static final Pattern BLAZE_RULE_START = Pattern.compile(
      "^[\\s]*/\\*[\\s]*\\<!\\-\\-[\\s]*#BLAZE_RULE[\\s]*\\(([\\w\\s=,+/()-]+)\\)"
      + "(\\[[\\w,]+\\])?[\\s]*\\-\\-\\>");
  /**
   * i.e. <!-- #END_BLAZE_RULE -->
   */
  public static final Pattern BLAZE_RULE_END = Pattern.compile(
      "^[\\s]*\\<!\\-\\-[\\s]*#END_BLAZE_RULE[\\s]*\\-\\-\\>[\\s]*\\*/");
  /**
   * i.e. <!-- #BLAZE_RULE.EXAMPLE -->
   */
  public static final Pattern BLAZE_RULE_EXAMPLE_START = Pattern.compile(
      "[\\s]*\\<!--[\\s]*#BLAZE_RULE.EXAMPLE[\\s]*--\\>[\\s]*");
  /**
   * i.e. <!-- #BLAZE_RULE.END_EXAMPLE -->
   */
  public static final Pattern BLAZE_RULE_EXAMPLE_END = Pattern.compile(
      "[\\s]*\\<!--[\\s]*#BLAZE_RULE.END_EXAMPLE[\\s]*--\\>[\\s]*");
  /**
   * i.e. <!-- #BLAZE_RULE(RULE_NAME).VARIABLE_NAME -->
   */
  public static final Pattern BLAZE_RULE_VAR_START = Pattern.compile(
      "^[\\s]*/\\*[\\s]*\\<!\\-\\-[\\s]*#BLAZE_RULE\\(([\\w\\$]+)\\)\\.([\\w]+)[\\s]*\\-\\-\\>");
  /**
   * i.e. <!-- #END_BLAZE_RULE.VARIABLE_NAME -->
   */
  public static final Pattern BLAZE_RULE_VAR_END = Pattern.compile(
      "^[\\s]*\\<!\\-\\-[\\s]*#END_BLAZE_RULE\\.([\\w]+)[\\s]*\\-\\-\\>[\\s]*\\*/");
  /**
   * i.e. <!-- #BLAZE_RULE(RULE_NAME).ATTRIBUTE(ATTR_NAME) -->
   * i.e. <!-- #BLAZE_RULE(RULE_NAME).ATTRIBUTE(ATTR_NAME)[DEPRECATED] -->
   */
  public static final Pattern BLAZE_RULE_ATTR_START = Pattern.compile(
      "^[\\s]*/\\*[\\s]*\\<!\\-\\-[\\s]*#BLAZE_RULE\\(([\\w\\$]+)\\)\\."
      + "ATTRIBUTE\\(([\\w]+)\\)(\\[[\\w,]+\\])?[\\s]*\\-\\-\\>");
  /**
   * i.e. <!-- #END_BLAZE_RULE.ATTRIBUTE -->
   */
  public static final Pattern BLAZE_RULE_ATTR_END = Pattern.compile(
      "^[\\s]*\\<!\\-\\-[\\s]*#END_BLAZE_RULE\\.ATTRIBUTE[\\s]*\\-\\-\\>[\\s]*\\*/");

  public static final Pattern BLAZE_RULE_FLAGS = Pattern.compile("^.*\\[(.*)\\].*$");

  public static final Map<String, Integer> ATTRIBUTE_ORDERING = ImmutableMap
      .<String, Integer>builder()
      .put("name", -99)
      .put("deps", -98)
      .put("src", -97)
      .put("srcs", -96)
      .put("data", -95)
      .put("resource", -94)
      .put("resources", -93)
      .put("out", -92)
      .put("outs", -91)
      .put("hdrs", -90)
      .build();

  static String toCommandLineFormat(String cmdDoc) {
    // Replace html <br> tags with line breaks
    cmdDoc = cmdDoc.replaceAll("(<br>|<br[\\s]*/>)", "\n") + "\n";
    // Replace other links <a href=".*">s with human readable links
    cmdDoc = cmdDoc.replaceAll("\\<a href=\"([^\"]+)\">[^\\<]*\\</a\\>", "$1");
    // Delete other html tags
    cmdDoc = cmdDoc.replaceAll("\\<[/]?[^\\>]+\\>", "");
    // Delete docgen variables
    cmdDoc = cmdDoc.replaceAll("\\$\\{[\\w_]+\\}", "");
    // Substitute more than 2 line breaks in a row with 2 line breaks
    cmdDoc = cmdDoc.replaceAll("[\\n]{2,}", "\n\n");
    // Ensure that the doc starts and ends with exactly two line breaks
    cmdDoc = cmdDoc.replaceAll("^[\\n]+", "\n\n");
    cmdDoc = cmdDoc.replaceAll("[\\n]+$", "\n\n");
    return cmdDoc;
  }
}
