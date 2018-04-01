# Multimedia

@(IT Studies)

## Digital Data
-------------------------------------
### Analog to Digital
1. Sampling -> Quantization
2. Bit rate = (bits/sec) = Sampling rate (sampling frequency) x Quantization bits per sample = F * Q
3. NYQUIST’S SAMPLING THEOREM
    >Sampling frequency should be at least 2F for a signal whose maximum frequency is F
    <==> 2 cut-off F = F we sampled

if less then 2F, aliasing
4. filter: to avoid aliasing, digital low-pass filter before subsampling
5. Scan
    1. Progressive - left to right, top to bottom
    2. Interlaced - even line, odd lines 
6. subsampling
![Alt text](./Screen Shot 2018-03-31 at 10.40.33 PM.png)


## Color  Theory
-------------------------------------
### Frequency
- Red to Purple : f -> low to high
- f = v / Wavelength = 1/T
- different spectrum can be same perceived color C

### Projector
- P(primaries) = 3 light sources, associated with M
- M {m1, m2, m3} = filters, generate channels
- a {a1, a2, a3} = channels
- g = generated spectrum

#### Different Filters
- RGB -> associated with primaries
- XYZ -> CIE


## Information  Theory & Compression
-------------------------------------
### 计算1：
If your vocabulary has N symbols, each symbol represented with log 2 N bits.
<===> each symbol has x bits -> having 2's power of x symbols
- example:
> A(00), B(01), C(10), D(11)

### 计算2：
ith symbol length = l(i) bits
emit M symbols = M = m(i) 从i->N, has been emitted m(i) times
number of bits = l(i)m(i) 从i->N
average symbol length = L = l(i)m(i) / M
average bit rate = L / T
also, 
L = P(i)l(i) 从i->N
Entropy (H) is highest (equal to log 2 N) if all symbols are equally probable
Entropy is small (always > 0) when some symbols that are much more likely to appear than other symbols

### Lossless Compression
ENTROPY ENCODING
- LZW – PATTERN SUBSTITUTION
- HUFFMAN CODING
- ARITHMETIC CODING

### Lossy Compression
Lossy Compression is always a tradeoff between rate (number of bits used) and distortion
<==> R 和 distortion 成反比

- DPCM
- TRANSFORM CODING


## Image Compression
-------------------------------------
Resolution越高，单位面积内pixel越多，pixel密度(ppi) 越大
1080p: 1920×1080 px, HD (high-definition)

### JPEG COMPRESSION ALGORITHMIC
1. 8x8 pixels
2. DCT
3. scalar quantization
4. entropy coder

### JPEG-2000
JPEG-2000 has better compression performances than JPEG， high complexity
- divided into tiles, then quantized
- Each code-block is entropy-coded independently
- encoded “naturally” progressively

### DITHERING
Normally done by dividing the image into k x k blocks. Each block can represent k2 +1 intensity levels.


## Digital Rights Management
------------------------------------
> copyright protection

watermarking
encryption