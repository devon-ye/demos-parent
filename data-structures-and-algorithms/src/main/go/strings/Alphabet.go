package strings

var BINARY string = "01"

const DNA string = "AGCT"
const OCTAL string = "01234567"
const DECIMAL string = "0123456789"
const HEXADECIMAL string = "0123456789ABCDEF"
const PROTEIN string = "ACDEFGHIKLMNPQRSTVWY"
const LOWERCASE string = "abcdefghijklmnopqrstuvwxyz"
const UPERCASE string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
const BASE64 string = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
const ASCII string = "128"
const EXTENDED_ASCII string = "256"
const UNICODE16 string = "65536"

type Alphabet interface {
	toChar(index int) uint16

	toIndex(c uint16) int

	contains(c uint16) bool

	//基数（字母表中的字符数量）
	R() int

	//表示一个索引所需的比特数
	lgR() int

	//将s转换为R进制的整数
	toIndices(s string) []int

	toChars(indices []int) string
}

type Alphabets struct {
	R        int
	alphabet [256]uint16
	indices  [256]int
}

func newAlphabets(radix int) *Alphabets {
	alphabets := [256]uint16{}
	indices := [256]int{}
	var i int = 0
	for i = 0; i < radix; i++ {
		alphabets[i] = uint16(i)
	}

	return &Alphabets{
		R:        radix,
		alphabet: alphabets,
		indices:  indices,
	}
}

func (alphabet Alphabets) toChar(index int) uint16 {
	return uint16(0)
}

func (alphabet Alphabets) toIndex(char uint16) int {
	return int(0)
}

func (alphabet Alphabets) cotains(char uint16) bool {
	return bool(false)
}

func (alphabet Alphabets) Rs() int {
	return int(0)
}

func (alphabet Alphabets) lgR() int {
	return int(0)
}

func (alphabet Alphabets) toIndices(s string) []int {
	return []int{}
}

func (alphabet Alphabets) toChars(indices []int) string {
	return string("")
}
